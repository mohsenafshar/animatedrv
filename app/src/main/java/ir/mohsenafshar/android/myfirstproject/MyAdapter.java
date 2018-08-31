package ir.mohsenafshar.android.myfirstproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> strings;

    public MyAdapter(List<String> strings) {
        this.strings = strings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(strings.get(i));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv);
        }
    }
}
