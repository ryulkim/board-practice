package boardcafe.boardpractice.paging.presentation;

import boardcafe.boardpractice.paging.application.ArticleService;
import boardcafe.boardpractice.paging.application.response.ArticleItem;
import boardcafe.boardpractice.paging.domain.Article;
import boardcafe.boardpractice.paging.presentation.response.getAllArticlesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/paging")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/offset")
    public ResponseEntity<getAllArticlesResponse> getAllArticles(Pageable pageable) {
        Page<ArticleItem> allArticles = articleService.getAllArticles(pageable);
        return ResponseEntity.ok(new getAllArticlesResponse(allArticles.getTotalPages(),allArticles.getContent()));
    }
}
