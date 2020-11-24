package cn.elook.indent.service.impl;

import cn.elook.common.entity.Indent;
import cn.elook.indent.dao.IndentDao;
import cn.elook.indent.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class IndentServiceImpl implements IndentService {

    @Autowired
    private IndentDao indentDao;

    @Override
    public List<Indent> findAll() {
        return indentDao.findAll();
    }

    @Override
    public Indent findById(Integer oId) {
        return indentDao.findById(oId);
    }

    @Override
    public void saveIndent(Indent indent) {
        indentDao.saveIndent(indent);
    }

    @Override
    public void deleteIndentById(Integer oId) {
        indentDao.deleteIndentById(oId);
    }
}
