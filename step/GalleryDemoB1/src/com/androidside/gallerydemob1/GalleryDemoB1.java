package com.androidside.gallerydemob1;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class GalleryDemoB1 extends Activity {
    //Gallery에서 보여줄 이미지를 지정한다.
    //이미지들은 /res/drawable-hdpi 아래에 pic1.jpg, pic2.jpg 와 같은 이름으로 저장한다.
    //이미지 이름은 숫자로 시작해서는 안되며 영문자, 숫자, _ 문자로 구성되어야 한다.
    Integer[] images = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                         R.drawable.pic4, R.drawable.pic5, R.drawable.pic6 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // /res/layout/gallerydemo1.xml에 선언한 gallery1라는 이름을 가진 Gallery를 불러온다.
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);

        //갤러리에서 보여줄 이미지를 처리하는 어댑터를 설정한다.
        //ImageAdapter는 BaseAdapter를 확장해서 만들어야 한다.
        gallery.setAdapter(new ImageAdapter(this));
        
        //갤러리의 이미지를 클릭했을 때 해당 이미지를 크게 보여주기 위한 로직을 설정한다.
        //OnItemClickListener 객체를 갤러리에 설정하면 클릭 이벤트가 발생했을 때 원하는 처리를 할 수 있다.
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position,
                    long id) {
                //갤러리에서 선택된 이미지를 보여주기 위한 ImageView를 가지고 온다.
                ImageView imageView = (ImageView) findViewById(R.id.image1);
            
                //ImageView에 표시되는 이미지를 가로, 세로 비율에 맞게 보여질 수 있도록 설정한다.
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                
                //사용자가 선택한 위치에 있는 이미지를 ImageView에 설정한다.
                //사용자가 선택한 이미지의 위치는 position으로 알 수 있으며
                //이를 통해 배열에서 적절한 이미지를 얻으면 된다.
                imageView.setImageResource(images[position]);
            }
        });
    }

    //갤러리에 보여질 이미지 어댑터를 선언한다.
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
    
        public ImageAdapter(Context c) {
            context = c;
            
            //갤러리를 표현하기 위한 배경 스타일을 얻는다.
            //R.styleable.Gallery1은 갤러리를 위한 스타일을 지정하기 위한 이름이며
            //이 예제에서는 /res/values/gallerydemo1_style.xml에 작성한다.
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
            //스타일 정보에서 갤러리 배경 스타일을 얻는다.
            itemBackground = a.getResourceId(
                    R.styleable.Gallery1_android_galleryItemBackground, 0);
            
            //갤러리 배경 스타일을 얻기 위해 사용했던 자원을 해지한다.
            a.recycle();
        }
    
        //이미지 전체 개수를 반환한다.
        public int getCount() {
            return images.length;
        }
    
        //주어진 position에 대한 이미지 리소스 아이디를 반환한다.
        public Integer getItem(int position) {
            return images[position];
        }
    
        //주어진 position에 대한 이미지 리소스 아이디를 반환한다.        
        public long getItemId(int position) {
            return position;
        }
    
        //주어진 position 에 대한 ImageView를 반환한다.
        public View getView(int position, View convertView, ViewGroup parent) {
            //ImageView를 생성한다.
            ImageView imageView = new ImageView(context);
            
            //주어진 position에 해당하는 이미지 리소스 아이드를 설정한다.
            imageView.setImageResource(getItem(position));
            
            //갤러리에 보여지는 이미지 크기를 설정한다. 100*80
            imageView.setLayoutParams(new Gallery.LayoutParams(100, 80));
            
            //ImageView 배경 스타일에 Gallery의 배경 스타일을 지정한다. 
            imageView.setBackgroundResource(itemBackground);
            
            //ImageView를 반환한다.
            return imageView;
        }
    } 
}