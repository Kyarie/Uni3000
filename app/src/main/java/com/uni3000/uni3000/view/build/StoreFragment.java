package com.uni3000.uni3000.view.build;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uni3000.uni3000.R;
import com.uni3000.uni3000.model.StoreItem;

import dagger.android.support.AndroidSupportInjection;

public class StoreFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void buyItem(String itemName);
        void sellItem(String itemName);
    }

    public void showItems(StoreItem item) {
        LinearLayout itemList = (LinearLayout)getView().findViewById(R.id.store_layout);
        View itemView = getActivity().getLayoutInflater().inflate(R.layout.store_item, null);
        TextView desc = itemView.findViewById(R.id.item_description);
        String label = getString(R.string.store_building_item_name) + item.label + "\n" +
                getString(R.string.store_building_price) + Integer.toString(item.price) + "\n" +
                getString(R.string.store_building_profit) + Integer.toString(item.profit);
        desc.setText(label);
        Button buyButton = itemView.findViewById(R.id.item_action);
        if (item.status == 'B') {
            buyButton.setText(R.string.sell_button);
            buyButton.setOnClickListener(sellClickListener(buyButton, item.nameId));
        } else {
            buyButton.setText(R.string.buy_button);
            buyButton.setOnClickListener(buyClickListener(buyButton, item.nameId));
        }
        itemList.addView(itemView);
    }

    OnClickListener buyClickListener(final Button button, final String nameId) {
        return new OnClickListener() {
            public void onClick(View v) {
                button.setText(R.string.sell_button);
                mListener.buyItem(nameId);
            }
        };
    }

    OnClickListener sellClickListener(final Button button, final String nameId) {
        return new OnClickListener() {
            public void onClick(View v) {
                button.setText(R.string.buy_button);
                mListener.sellItem(nameId);
            }
        };
    }
}
