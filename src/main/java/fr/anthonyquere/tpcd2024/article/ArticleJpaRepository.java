package fr.anthonyquere.tpcd2024.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides methods to manage articles in the database
 */
@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, String> {
}
