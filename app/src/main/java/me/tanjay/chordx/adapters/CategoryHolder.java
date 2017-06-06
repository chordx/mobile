package me.tanjay.chordx.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import me.tanjay.chordx.R;
import me.tanjay.chordx.models.CategoryModel;

public class CategoryHolder extends RecyclerView.Adapter<CategoryHolder.ViewHolder> {
//    ImageView imgView;
    private ArrayList<CategoryModel> category_models;
    public CategoryHolder(Context context, ArrayList<CategoryModel> employee_models){
        this.category_models = employee_models;
    }
    @Override
    public CategoryHolder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.empName.getContext();
//        holder.empID.setText(category_models.get(position).getCategoryId());
        holder.empName.setText(category_models.get(position).getCategoryName());
        holder.empDescription.setText(category_models.get(position).getCategoryDescription());
//        Log.d(MainResource.TAG_DEBUG, MainResource.getInstance().getEMPLOYEEUPLOAD() + category_models.get(position).getImage());
//        Picasso.with(context).load().into(imgView);
        Glide.with(context).load(category_models.get(position).getImageURI()).into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return category_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView empName;
        TextView empDescription;
        ImageView imgView;
        public ViewHolder(View itemView) {
            super(itemView);
            empName = (TextView) itemView.findViewById(R.id.title);
            empDescription = (TextView) itemView.findViewById(R.id.description);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(v.getContext());
                    dialog.setContentView(R.layout.popover);
                    dialog.setTitle("Game Over");
                    String mes = "";
                    ImageView wonImag = (ImageView) dialog.findViewById(R.id.won);
//                    if(score > 50) {
//                        mes = "Wow! Great Work Einstein";
//                        wonImag.setImageDrawable(getResources().getDrawable(R.drawable.won_img));
//                    }else {
//                        mes = "Should try a little harder!";
//                        wonImag.setImageDrawable(getResources().getDrawable(R.drawable.lost_img));
//                    }
                    TextView scoreR = (TextView) dialog.findViewById(R.id.scoreCount);
                    scoreR.setText("Score is ");

                    TextView message = (TextView)  dialog.findViewById(R.id.messageScore);
                    message.setText(mes);
                    Button share = (Button) dialog.findViewById(R.id.share);
                    share.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
//                        .setMessage(getString(R.string.invitation_message))
//                        .setDeepLink(Uri.parse(getString(R.string.invitation_deep_link)))
//                        .setCustomImage(Uri.parse(getString(R.string.invitation_custom_image)))
//                        .setCallToActionText(getString(R.string.invitation_cta))
//                        .build();
//                startActivityForResult(intent, REQUEST_INVITE);
                        }
                    });
                    Button dialogButton = (Button) dialog.findViewById(R.id.Leave);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
//                            Intent in = new Intent(NewGame.this, MainActivity.class);
//                            in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(in);
                        }
                    });

                    dialog.show();
                }
            });

//            empID = (TextView) itemView.findViewById(R.id.employeeID);
//            empOverall = (TextView) itemView.findViewById(R.id.employeeOverall);
//            imgView = (ImageView) itemView.findViewById(R.id.face);


        }
    }

}