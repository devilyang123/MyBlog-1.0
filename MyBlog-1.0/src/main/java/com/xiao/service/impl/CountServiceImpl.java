package com.xiao.service.impl;

import com.xiao.entity.Count;
import com.xiao.repository.CountRepository;
import com.xiao.service.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 博客总访问量service层实现类
 * @Auther: 笑笑
 * @Date: 10:50 2018/10/2
 */
@Service
public class CountServiceImpl implements ICountService {

    @Autowired
    private CountRepository countRepository;

    /**
     * @Description 查询访问量
     * @Date 10:51 2018/10/2
     * @Param
     * @return
     */
    @Override
    public Count getOne(Long countId) {
        Count count = countRepository.getOne(countId);
        if (count !=null){
            return count;
        }
        return null;
    }

    /**
     * @Description 保存访问量
     * @Date 10:53 2018/10/2
     * @Param
     * @return
     */
    @Override
    public boolean save(Count count) {
        Count c = countRepository.save(count);
        if(c != null){
            return true;
        }
        return false;
    }
}
