package com.paad.earthquake;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.LiveFolders;

public class EarthquakeLiveFolders extends Activity {

	private static Intent createLiveFolderIntent(Context context) {
	    Intent intent = new Intent();
	    intent.setData(EarthquakeProvider.LIVE_FOLDER_URI);
	    intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_BASE_INTENT,
	                    new Intent(Intent.ACTION_VIEW, EarthquakeProvider.CONTENT_URI));
	    intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_DISPLAY_MODE,
	                    LiveFolders.DISPLAY_MODE_LIST);
	    intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_ICON,
	                    Intent.ShortcutIconResource.fromContext(context, R.drawable.icon));
	    intent.putExtra(LiveFolders.EXTRA_LIVE_FOLDER_NAME, "지진 정보");
	    return intent;
	}
	
    public static class EarthquakeLiveFolder extends Activity {
    	@Override
    	public void onCreate(Bundle savedInstanceState) {
    	    super.onCreate(savedInstanceState);
    	    String action = getIntent().getAction();
    	    if (LiveFolders.ACTION_CREATE_LIVE_FOLDER.equals(action))
    	        setResult(RESULT_OK, createLiveFolderIntent(this));
    	    else
    	        setResult(RESULT_CANCELED);
    	    finish();
    	}
    }
}