package boardcafe.boardpractice.paging.presentation;

import boardcafe.boardpractice.paging.application.ArticleService;
import boardcafe.boardpractice.paging.application.response.ArticleItem;
import boardcafe.boardpractice.paging.presentation.request.createArticlesRequest;
import boardcafe.boardpractice.paging.presentation.response.getAllArticlesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/paging/offset")
    public ResponseEntity<getAllArticlesResponse> getAllArticles(Pageable pageable) {
        Page<ArticleItem> allArticles = articleService.getAllArticles(pageable);
        return ResponseEntity.ok(new getAllArticlesResponse(allArticles.getTotalPages()-1,allArticles.getContent()));
    }

    @PostMapping("/make")
    public ResponseEntity<Void> creatArticles(@RequestBody createArticlesRequest request) {
        articleService.createArticles(request.articles());
        return ResponseEntity.ok().build();
    }
}
