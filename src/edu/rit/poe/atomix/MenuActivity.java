/*
 * MenuActivity.java
 *
 * Version:
 *      $Id$
 *
 * Copyright (c) 2009 Peter O. Erickson
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without major
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, and/or distribute copies of, but
 * under no circumstances sublicense and/or sell, the Software,
 * and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package edu.rit.poe.atomix;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 *
 * @author  Peter O. Erickson
 *
 * @version $Id$
 */
public class MenuActivity extends Activity {
    
    /**
     * Called when the activity is first created.
     * 
     * @param   icicle  the bundle of saved state information
     */
    @Override
    public void onCreate( Bundle icicle ) {
        super.onCreate( icicle );
        
        super.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        
        
        
        // remove the titlebar (it's not needed)
        super.requestWindowFeature( Window.FEATURE_NO_TITLE );
        
        
        super.setContentView( R.layout.menu );
        
        GradientDrawable grad = new GradientDrawable( Orientation.TOP_BOTTOM,
            new int[] { Color.BLACK, Color.parseColor( "#CC0000" ) } );
        grad.setGradientRadius( 1.0f );
        grad.setGradientType( GradientDrawable.LINEAR_GRADIENT );
        
        super.getWindow().setBackgroundDrawable( grad );
        
        // setup button callbacks
        Button resume = ( Button )findViewById( R.id.resume );
		resume.setOnClickListener( new View.OnClickListener() {
			public void onClick( View view ) {
                // start the situation display
                Intent intent = new Intent( MenuActivity.this,
                        AtomicActivity.class );
                MenuActivity.super.startActivity( intent );
                
                // never resume the menu with the back button
                MenuActivity.super.finish();
			}
		} );
    }
    
    
    @Override
    protected void onSaveInstanceState( Bundle icicle ) {
        super.onSaveInstanceState( icicle );
        Log.d( "DROID_ATOMIX", "onSaveInstanceState() called." );
    }
    
    @Override
    public void onPause() {
        super.onPause();
        Log.d( "DROID_ATOMIX", "onPause() called." );
    }
    
    @Override
    protected void onRestoreInstanceState( Bundle icicle ) {
        super.onRestoreInstanceState( icicle );
        Log.d( "DROID_ATOMIX", "onRestoreInstanceState() called." );
    }
    
    @Override
    public void onResume() {
        super.onResume();
        Log.d( "DROID_ATOMIX", "onResume() called." );
    }
    
    
} // MenuActivity