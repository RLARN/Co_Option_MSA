package com.cooption.taskService.mapper;


import com.cooption.taskService.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TaskMapper {

    int insertTask(TaskVO taskVO);

    void modifyTask(TaskVO taskVO);

    List<TaskVO> selectTaskList(TaskVO requestVO);
    
    void completeYNChange(TaskVO taskVO);
}
