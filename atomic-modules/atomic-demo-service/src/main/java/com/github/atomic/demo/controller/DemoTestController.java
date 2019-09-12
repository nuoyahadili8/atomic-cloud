package com.github.atomic.demo.controller;
import java.util.Map;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.atomic.common.constant.CommonConstant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.atomic.common.util.Query;
import com.github.atomic.common.util.R;
import com.github.atomic.demo.entity.DemoTest;
import com.github.atomic.demo.service.DemoTestService;
import com.github.atomic.common.web.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author an
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/demoTest")
public class DemoTestController extends BaseController {
    @Autowired private DemoTestService demoTestService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return DemoTest
    */
    @GetMapping("/{id}")
    public R<DemoTest> get(@PathVariable Integer id) {
        return new R<>(demoTestService.selectById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return demoTestService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  demoTest  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody DemoTest demoTest) {
        return new R<>(demoTestService.insert(demoTest));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        DemoTest demoTest = new DemoTest();
        demoTest.setId(id);
        demoTest.setUpdateTime(new Date());
        demoTest.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(demoTestService.updateById(demoTest));
    }

    /**
     * 编辑
     * @param  demoTest  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody DemoTest demoTest) {
        demoTest.setUpdateTime(new Date());
        return new R<>(demoTestService.updateById(demoTest));
    }
}
