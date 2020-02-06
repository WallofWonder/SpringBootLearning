package com.example.demo.service;

import com.example.demo.generator.Article;
import com.example.demo.generator.ArticleMapper;
import com.example.demo.model.ArticleVO;
import com.example.demo.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {
    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;


    //新增
    @Override
    @CacheEvict(value = "article", key = "#article.getId()")
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.insert(articlePO);

        // TODO 把readers数组存入数据库
        article.setId(articlePO.getId());
        return article;
    }

    //删除
    @Override
    @CacheEvict(value = "article", key = "#id")
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    //更新
    @Override
    @CacheEvict(value = "article", key = "#article.getId()")
    public ArticleVO updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
        return article;
    }

    //查询
    @Override
    @Cacheable(value = "article", key = "#id", condition = "#id > 1")
    public ArticleVO getArticle(Long id) {
        // TODO 把读者信息查询出来赋值给articleVO
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id), ArticleVO.class);
    }

    //查询所有
    @Override
    @Cacheable(value = "articleAll")
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
