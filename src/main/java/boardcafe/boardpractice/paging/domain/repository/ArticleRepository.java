package boardcafe.boardpractice.paging.domain.repository;

import boardcafe.boardpractice.paging.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
//    Page<Article> findAll(Pageable pageable);
}
