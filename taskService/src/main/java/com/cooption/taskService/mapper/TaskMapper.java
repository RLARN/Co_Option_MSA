package com.cooption.taskService.mapper;


import com.cooption.taskService.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface TaskMapper {

    int insertTask(TaskVO taskVO);
}
