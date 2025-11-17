package fr.anthonyquere.tpcd2024.article;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Jpa entity representing an article in the database
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {
    @Id
    private String title;
}
