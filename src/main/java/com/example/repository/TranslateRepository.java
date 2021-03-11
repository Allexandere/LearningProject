package com.example.repository;

import com.example.model.Translation;
import com.example.model.TranslationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class TranslateRepository implements org.springframework.data.repository.Repository<Translation, Long> {

    @Autowired
    private EntityManager entityManager;

    public Translation getTranslation(TranslationRequest translationRequest) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Translation> query = builder.createQuery(Translation.class);
        Root<Translation> root = query.from(Translation.class);

        query.select(root).where(builder.equal(root.get("fromLanguage"), translationRequest.getFromLanguage()))
                .where(builder.equal(root.get("toLanguage"), translationRequest.getToLanguage()))
                .where(builder.equal(root.get("fromWord"), translationRequest.getWord()));

        return entityManager.createQuery(query).getResultStream().findFirst().orElse(null);
    }

    public Translation createTranslation(Translation translation) {
        entityManager.persist(translation);
        entityManager.flush();
        return translation;
    }
}
