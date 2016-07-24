package com.example.administrator.listview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.listview.R;
import com.example.administrator.listview.data.Person;

/**
 * Created by Administrator on 2016-07-24.
 */
public class PersonView extends FrameLayout {

    ImageView photoView;
    TextView nameView, ageView;

   public interface OnImageClickListener {
        public void onImageClick(PersonView view, Person person);
    }

    OnImageClickListener mListener;

    public void setOnClickListener(OnImageClickListener listener) {
        mListener = listener;
    }

    public PersonView(Context context) {
        super(context);
        init();
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        inflate(getContext(), R.layout.view_person, this);
        photoView = (ImageView)findViewById(R.id.image_photo);
        nameView = (TextView)findViewById(R.id.text_name);
        ageView = (TextView)findViewById(R.id.text_age);
        photoView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onImageClick(PersonView.this, person);
                }
            }
        });

    }

    Person person;
    public void setPerson(Person person) {
        this.person = person;
        nameView.setText(person.getName());
        ageView.setText(""+person.getAge());
        photoView.setImageDrawable(person.getPhoto());
    }

    public Person getPerson() {
        return person;
    }
}
