package com.codes.blues.api.tdemo;

import com.codes.blues.api.BaseController;
import com.codes.blues.core.model.R;
import com.codes.blues.dao.tdemo.model.Tdemo;
import com.codes.blues.service.tdemo.TdemoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author ：linzg
 * @date ：Created in 2020/3/3 11:06
 * @description：tdemo
 */
@Api(description = "tdemo操作接口")
@RestController
@RequestMapping("tdemo")
public class TdemoController extends BaseController {

    @Autowired
    TdemoService tdemoService;

    @ApiOperation(value = "查找一个", notes = "用于单个查询")
    //@ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query", dataType = "Integer")
    @ApiResponses({
            @ApiResponse(code = 400, message = "没找到资源"),
            @ApiResponse(code = 500, message = "扑街啦~~")
    })
    @GetMapping("/findOne/{id}")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", dataType = "int", required = true)
    public R<Tdemo> findOne(@PathVariable Integer id) {
        return R.data(tdemoService.findOne(id));
    }

    @GetMapping("/findAllById/{id}")
    public R<List<Tdemo>> findAllById(@PathVariable Integer id) {
        return R.data(tdemoService.findAllById(id));
    }

    @ApiIgnore
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("/hello");
        return modelAndView;
    }

    //@ApiIgnore
    @GetMapping("/hello3")
    public ModelAndView thymeleaf() {
        ModelAndView modelAndView = new ModelAndView("html/hello3");
        return modelAndView;
    }



    public static void main(String[] args) {
        System.out.println(8>>2);
    }
}
