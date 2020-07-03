package com.demo.webadmin.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demo.webadmin.common.BaseController;
import com.demo.webadmin.common.ResponseResult;
import com.demo.webadmin.entity.User;
import com.demo.webadmin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chen.chao
 * @since 2020-07-02
 */
@Api(tags = "[]模块 前端接口(2020-07-02)")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;


	@ApiOperation(value = "基础方法:新增", notes = "基础方法:新增")
	@PostMapping(value = "/insert")
	public ResponseResult<?> insert(User user) {
		return userService.insert(user) ? ResponseResult.success() : ResponseResult.error();
	}

	@ApiOperation(value = "基础方法:删除", notes = "基础方法:删除")
	@DeleteMapping(value = "/delete")
	public ResponseResult<?> delete(User user) {
//                throw new IllegalArgumentException("暂不支持");
		return userService.deleteById(user.getId()) ? ResponseResult.success() : ResponseResult.error();
	}

	@ApiOperation(value = "基础方法:批量删除", notes = "基础方法:批量删除")
	@PostMapping(value = "/batch")
	public ResponseResult<?> delete(@RequestParam("ids") List<Long> ids) {
//                throw new IllegalArgumentException("暂不支持");
		return userService.deleteBatchIds(ids) ? ResponseResult.success() : ResponseResult.error();
	}

	@ApiOperation(value = "基础方法:修改", notes = "基础方法:修改")
	@PostMapping(value = "/update")
	public ResponseResult<?> update(User user) {
		return userService.updateById(user) ? ResponseResult.success() : ResponseResult.error();
	}


	@ApiOperation(value = "基础方法:列表", notes = "基础方法:列表")
	@GetMapping(value = "/list")
	public ResponseResult<?> list(User user) {
		return ResponseResult.success(userService
				.selectList(new EntityWrapper<>(user)));
	}

	@ApiOperation(value = "基础方法:查询", notes = "基础方法:查询")
	@GetMapping(value = "/find/{id}")
	public ResponseResult<?> page(@PathVariable("id") Serializable id) {
		return ResponseResult.success(userService.selectById(id));
	}

}

