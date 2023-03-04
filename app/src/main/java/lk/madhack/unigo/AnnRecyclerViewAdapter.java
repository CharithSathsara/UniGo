package lk.madhack.unigo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lk.madhack.unigo.model.Announcement;
import lk.madhack.unigo.model.Event;

public class AnnRecyclerViewAdapter extends RecyclerView.Adapter<AnnRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Announcement> announcements;

    public AnnRecyclerViewAdapter(Context ct, List<Announcement> announcements){
        this.context = ct;
        this.announcements = announcements;
    }

    @NonNull
    @Override
    public AnnRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.listitem,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnRecyclerViewAdapter.MyViewHolder holder, int position) {

        Announcement ann = announcements.get(position);

        String announce = announcements.get(position).getAnnouncement();

        holder.txtAnnouncement.setText(announce);

        holder.myAnnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context,.class);
//                intent.putExtra("employee",employee);
//                intent.putExtra("salary",salary);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtAnnouncement;
        LinearLayout myAnnLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtAnnouncement = itemView.findViewById(R.id.txtAnnouncement);
            myAnnLayout = itemView.findViewById(R.id.myAnnLayout);
        }
    }

}
