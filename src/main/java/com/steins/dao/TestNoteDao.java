package com.steins.dao;

import com.steins.entity.TestNote;

public interface TestNoteDao {
    //获得考试记录对象
    public TestNote getTestNote(Integer tnid);
    //保存考试结束时间
    public void saveTestNote(TestNote tn);

}
