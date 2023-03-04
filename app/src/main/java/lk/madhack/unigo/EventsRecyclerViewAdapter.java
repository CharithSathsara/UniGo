package lk.madhack.unigo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lk.madhack.unigo.model.Event;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Event> events;

    public EventsRecyclerViewAdapter(Context ct,List<Event> events){
        this.context = ct;
        this.events = events;
    }

    @NonNull
    @Override
    public EventsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.eventitem,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsRecyclerViewAdapter.MyViewHolder holder, int position) {

        Event event = events.get(position);

        String eventName = events.get(position).getName();
        String eventDate = events.get(position).getDate();

        String data = eventName + "\nDate : " + eventDate;

        holder.txtEvent.setText(data);

        holder.myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtEvent;
        LinearLayout myLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtEvent = itemView.findViewById(R.id.txtEvent);
            myLayout = itemView.findViewById(R.id.myLayout);
        }
    }

}
