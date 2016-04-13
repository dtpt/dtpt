package com.dt.dtpt.service;

import com.dt.dtpt.util.Page;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public abstract interface IService<T>
{
  public static final int MIN_PAGE_SIZE = 1;
  public static final int DEF_PAGE_SIZE = 10;
  public static final int MAX_PAGE_SIZE = 100;

  public abstract T selectByKey(Object paramObject);

  public abstract int save(T paramT);

  public abstract int delete(Object paramObject);

  public abstract int updateAll(T paramT);

  public abstract int updateNotNull(T paramT);

  public abstract List<T> selectByExample(Object paramObject);

  public abstract List<T> findAll();

  public abstract Page<T> queryByPage(T paramT, int paramInt1, int paramInt2);
}