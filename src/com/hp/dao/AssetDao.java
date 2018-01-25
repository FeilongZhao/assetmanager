package com.hp.dao;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.Asset1;
import com.hp.po.User;

public interface AssetDao {

    List<Asset1> findAsset(int userId);

    Boolean addAsset(Asset asset);

    Boolean deleteAssert(int bankId, int userId);

    double findAll(int userId);

    Boolean updateAsser(Asset asset);

    Boolean reduceAsset(Asset asset);
    double chakan(Asset asset);

}
