package com.example.tugaspas_22_10rpl1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private static DataAdapter data;


    public static DataAdapter getData() {
        if (data == null) data = new DataAdapter();
        return data;
    }

    public static final ArrayList<Data> datalist = new ArrayList<>();


    private DataAdapter() {

    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dataview, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.namaData.setText(datalist.get(position).getNama());
        holder.noHpData.setText(datalist.get(position).getNoHp());

    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size() : 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, View.OnClickListener, MenuItem.OnMenuItemClickListener {
        private TextView namaData, noHpData;
        CardView cardviewku;

        public DataViewHolder(View itemView) {
            super(itemView);
            //viewku = itemView;
            itemView.setOnCreateContextMenuListener(this);
            namaData = (TextView) itemView.findViewById(R.id.nama_data);
            noHpData = (TextView) itemView.findViewById(R.id.noHp_data);
            cardviewku = (CardView) itemView.findViewById(R.id.cardviewku);
            cardviewku.setOnClickListener(this::onClick);

        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            //posku = getAdapterPosition();
            Edit.setOnMenuItemClickListener(this::onMenuItemClick);
            Delete.setOnMenuItemClickListener(this::onMenuItemClick);
        }

        @Override
        public void onClick(View v) {
            Intent move = new Intent(MainActivity.getMain(),DetailPage.class);
            Data dataku = datalist.get(getAdapterPosition());
            move.putExtra("nama", dataku.getNama());
            move.putExtra("noHp", dataku.getNoHp());
            MainActivity.getMain().startActivity(move);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case 1 :
                    Toast.makeText(MainActivity.getMain(), "Edit kontak ke " +getAdapterPosition(),Toast.LENGTH_SHORT).show();
                    break;
                case 2 :
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.getMain());
                    builder.setMessage("Are you sure want to delete this data")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    datalist.remove(getAdapterPosition());
                                    notifyDataSetChanged();
                                }
                            })


                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })


                            .setTitle("Delete data")
                            .setIcon(R.drawable.user);
                    AlertDialog alert = builder.create();
                    alert.show();
                    break;


            }
            return true;
        }
    }


    public void addData(String username, String number){
        datalist.add(new Data(username, number));
        for (Data data2:datalist) {
            System.out.println(data2.getNama());
            System.out.println(data2.getNoHp());

        }
    }
}
