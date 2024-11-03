package boardcafe.boardpractice.paging.application;

import boardcafe.boardpractice.paging.application.response.ArticleItem;
import boardcafe.boardpractice.paging.domain.Article;
import boardcafe.boardpractice.paging.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Page<ArticleItem> getAllArticles(Pageable pageable) {
        Page<Article> pages = articleRepository.findAll(pageable);
        return pages.map(ArticleItem::of);
    }
}
