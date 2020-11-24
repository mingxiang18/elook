package cn.elook.indent.service;

import cn.elook.common.entity.Indent;

import java.util.List;

public interface IndentService {
    public List<Indent> findAll();

    public Indent findById(Integer oId);

    public void saveIndent(Indent indent);

    public void deleteIndentById(Integer oId);
}
