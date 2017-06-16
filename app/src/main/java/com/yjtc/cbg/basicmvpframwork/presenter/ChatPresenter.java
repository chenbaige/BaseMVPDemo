package com.yjtc.cbg.basicmvpframwork.presenter;

import com.yjtc.cbg.basicmvpframwork.data.http.ApiService;
import com.yjtc.cbg.basicmvpframwork.data.model.ChatModel;
import com.yjtc.cbg.basicmvpframwork.ui.base.BasePresenter;
import com.yjtc.cbg.basicmvpframwork.ui.contract.ChatContract;

import javax.inject.Inject;

/**
 * Title: basicmvpframwork
 * <p/>
 * Description:
 * <p/>
 * Author:baigege (baigegechen@gmail.com)
 * <p/>
 * Date:2017-06-13
 */
public class ChatPresenter extends BasePresenter<ChatContract.IChatView, ChatModel> implements ChatContract.IChatPresenter {

    @Inject
    public ChatPresenter(ApiService service) {
        super(service);
        this.mModel = new ChatModel(service);
    }


}
