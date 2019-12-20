package cn.xhp.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;

import cn.xhp.pojo.TbDescription;

@Service
@Transactional//本地事务
public class TestServiceImpl implements TestService {

    @PersistenceContext //注入的是实体管理器,执行持久化操作
    EntityManager entityManager;

    @LcnTransaction//分布式事务
    @Override
    public TbDescription txlcn(Integer userId) {
        TbDescription tbDescription = new TbDescription();
        tbDescription.setUserId(userId);
        tbDescription.setDescription("服务C设置的描述");
        return entityManager.merge(tbDescription);
    }
}
