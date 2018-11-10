package com.example.tip.trackinsurancepolicy.Data;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tip.trackinsurancepolicy.Model.Policy;
import com.example.tip.trackinsurancepolicy.R;

import java.util.List;

public class PolicyList extends ArrayAdapter<Policy>{
    private Activity context;
    private List<Policy> policylist;

    public PolicyList(Activity context, List<Policy> policylist){
        super(context, R.layout.list_layout, policylist);
        this.context=context;
        this.policylist = policylist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textView13);
        TextView textViewPremAmt = (TextView) listViewItem.findViewById(R.id.textView14);
        TextView textViewComp = (TextView) listViewItem.findViewById(R.id.textView15);

        Policy policy = policylist.get(position);
        textViewName.setText(policy.getPolicyName());
        textViewComp.setText(policy.getpCompany());
        textViewPremAmt.setText(policy.getPolicyNo());

        return listViewItem;
    }
}
