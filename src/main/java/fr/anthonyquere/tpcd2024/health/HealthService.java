package fr.anthonyquere.tpcd2024.health;

import fr.anthonyquere.tpcd2024.article.ArticleEntity;
import fr.anthonyquere.tpcd2024.article.ArticleJpaRepository;
import fr.anthonyquere.tpcd2024.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HealthService {

    private final ArticleService articleService;

    public HealthStatusDto getStatus() {

        var articleName = "Some article  " + System.currentTimeMillis();

        Optional<ArticleEntity> savedArticle;
        try {
            articleService.saveArticle(articleName);
            savedArticle = articleService.getArticleByName(articleName);
        } catch (Exception e) {
            return new HealthStatusDto("Error when communicating to the database " + e.getMessage(), HealthStatusDto.Status.DOWN);
        }

        if (savedArticle.isEmpty()) {
            return new HealthStatusDto("Data base communicated in a weird way", HealthStatusDto.Status.DOWN);
        }

        return new HealthStatusDto("DB is ok", HealthStatusDto.Status.UP);
    }
}
