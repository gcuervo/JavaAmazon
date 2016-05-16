/**
 * 
 */
package com.websystique.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Article;
import com.websystique.springmvc.service.ArticleService;

@Controller
@RequestMapping(value = { "/" })
/**
 * @author martin.medina
 *
 */
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = {"/listArticles" }, method = RequestMethod.GET)
	public String listArticles(ModelMap model) {

		List<Article> articles = articleService.listAllArticles();
		model.addAttribute("articles", articles);
		return "articles/allArticles";
	}

	@RequestMapping(value = { "/delete-{id_user}-article" }, method = RequestMethod.GET)
	public String deleteArticles(@PathVariable int id_user) {
		articleService.deleteArticleByIdUser(id_user);
		return "redirect:articles/listArticles";
	}
	
	/*****************************ARTICLES_START****************************/
	/*
	 * This method will provide the medium to add a new User.
	 */
	@RequestMapping(value = { "/registrationArticle" }, method = RequestMethod.GET)
	public String newArticle(ModelMap model) {
		System.out.println("Llega acá - New Article");
		Article article = new Article();
		model.addAttribute("article", article);
		return "articles/registrationArticle";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/registrationArticle" }, method = RequestMethod.POST)
	public String saveArticle(@Valid Article article, BindingResult result, ModelMap model) {
		DateTimeFormatter dateFormat = DateTimeFormat.forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");

		System.out.println("Llega acá - Save Article");
		LocalDate localDate = new LocalDate();
		DateTime dateTime = new DateTime();
		LocalDateTime localDateTime = new LocalDateTime();
		DateTimeZone dateTimeZone = DateTimeZone.getDefault();

		article.setCreationDate(localDate);
		
		System.out.println(article.getCreationDate());
		
		article.setDeleted(1);
		article.setState(0);

		if (result.hasErrors()) {
			return "articles/registrationArticle";
		}

		/*
		 * Preferred way to achieve uniqueness of field [email] should be
		 * implementing custom @Unique annotation and applying it on field
		 * [email] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 * 
		 */
//		if (!userService.isUserEmailUnique(article.getId(), article.getEmail())) {
//			FieldError emailError = new FieldError("user", "email", messageSource.getMessage("non.unique.email",
//					new String[] { article.getEmail() }, Locale.getDefault()));
//			result.addError(emailError);
//			return "registrationUser";
//		}

		articleService.saveArticle(article);

		model.addAttribute("success", "Article " + article.getName() + " Registered Successfully");
		return "articles/successArticle";
	}	
	/*****************************ARTICLES_END****************************/

}
