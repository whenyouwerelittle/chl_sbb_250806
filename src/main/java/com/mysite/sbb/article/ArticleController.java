package com.mysite.sbb.article;
import java.util.List;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    // private final ArticleRepository articleRepository;
    private final ArticleService articleService;
    @GetMapping("/list")
    // @ResponseBody
    public String list(Model model){
        // List<Article> articleList = this.articleRepository.findAll();
        // 컨트롤러 → 서비스 → 리포지터리
        List<Article> articleList = this.articleService.getList();
        if(!articleList.isEmpty()){
            model.addAttribute("articleList", articleList);
            return "article_list";
        }else{
            return "No_Article_is_available";
        }
    }

/*    @GetMapping(value = "/article/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "article_detail";
    }*/
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }
    @GetMapping(value = "/create")
    public String articleCreate(ArticleForm articleForm) {
        return "article_form";
    }

    @PostMapping(value = "/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list"; // 질문 저장후 질문목록으로 이동
    }
}
