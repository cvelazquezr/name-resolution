import android.view.View;

View rootView = inflater.inflate(R.layout.article_fragnment, this, false);
TextView txtView = rootView.findViewById(R.id.like).setOnClickListener( new ResultLikeListener( this,(TextView)findViewById(R.id.like), res ));
