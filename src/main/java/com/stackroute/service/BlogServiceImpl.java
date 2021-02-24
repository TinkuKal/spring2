package com.stackroute.service;

import com.stackroute.domain.Blog;
import com.stackroute.exceptions.BlogAlreadyExistsException;
import com.stackroute.exceptions.BlogNotFoundException;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/* This is ServiceImplementation Class which should implement BlogService Interface and override all the implemented methods.
 * Handle suitable exceptions for all the implemented methods*/

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  BlogRepository repository;

  @Override
  public Blog saveBlog(Blog blog) throws BlogAlreadyExistsException {
    Optional<Blog> b = repository.findById(blog.getBlogId());
    if(b.isPresent()) throw new BlogAlreadyExistsException();
    else{
      return repository.save(blog);
    }
  }

  @Override
  public List<Blog> getAllBlogs() {
    return (List<Blog>) repository.findAll();
  }

  @Override
  public Blog getBlogById(int id) throws BlogNotFoundException {
    Optional<Blog> blog = repository.findById(id);
    if(blog.isPresent()) {
      repository.findById(id);
      return blog.get();
    }
    else throw new BlogNotFoundException();
  }

  @Override
  public Blog deleteBlog(int id) throws BlogNotFoundException {
    if(repository.existsById(id)){
      Blog b = repository.findById(id).get();
      repository.deleteById(id);
      return b;
    }
//    Optional<Blog> blog = repository.findById(id);
//    if(blog.isPresent()) {
//      Blog b = blog.get();
//      repository.deleteById(id);
//      return b;
//    }
//    return null;gcc
    else throw new BlogNotFoundException();
  }

  @Override
  public Blog updateBlog(Blog blog) throws BlogNotFoundException {
    if(repository.existsById(blog.getBlogId())){
      Optional<Blog> b = repository.findById(blog.getBlogId());
      return repository.save(blog);
    }
    else throw new BlogNotFoundException();
  }
}

