package com.yjtc.cbg.basicmvpframwork.data.model;

import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.ui.base.BaseModel;
import com.yjtc.cbg.basicmvpframwork.ui.contract.ChatContract;

/**
 * Title: basicmvpframwork
 * <p>
 * Description:
 * <p>
 * Author:baigege (baigegechen@gmail.com)
 * <p>
 * Date:2017-06-13
 */
public class ChatModel extends BaseModel implements ChatContract.IChatModel{


    public ChatModel(ApiService service) {
        super(service);
    }
}
