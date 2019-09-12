package com.github.atomic.demo.service.impl;

import com.github.atomic.demo.entity.DemoTest;
import com.github.atomic.demo.mapper.DemoTestMapper;
import com.github.atomic.demo.service.IDemoTestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author an
 * @since 2019-01-07
 */
@Service
public class DemoTestServiceImpl extends ServiceImpl<DemoTestMapper, DemoTest> implements IDemoTestService {

}
