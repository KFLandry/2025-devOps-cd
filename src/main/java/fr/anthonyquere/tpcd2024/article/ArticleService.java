package fr.anthonyquere.tpcd2024.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Manages articles
 */
@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleJpaRepository articleJpaRepository;

    /**
     * IDK did someone even read that ?
     * @param name article name
     * @return the article if founded
     */
    public Optional<ArticleEntity> getArticleByName(String name) {
        return articleJpaRepository.findById(name);
    }

    public void saveArticle(String name) {
        articleJpaRepository.save(
                new ArticleEntity(name)
        );
    }
}
