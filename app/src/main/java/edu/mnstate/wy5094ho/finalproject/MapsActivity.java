package edu.mnstate.wy5094ho.finalproject;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final Marker sydn;
        final Marker per;
        final Marker br;
        final Marker eg;
        final Marker sa;
        final Marker chi;
        final Marker ind;
        final Marker aus;



        // Add a marker in Sydney and move the camera
        final LatLng sydney = new LatLng(-34, 151);
        MarkerOptions sydneyM = new MarkerOptions();
        sydn= mMap.addMarker(sydneyM.position(sydney).title("Marker in Sydney"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        final LatLng Peru = new LatLng(-12.046374, -77.042793);

        MarkerOptions peruM = new MarkerOptions();
        per=mMap.addMarker(peruM.position(Peru).title("Marker in Peru"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(Peru));

        final LatLng brazil = new LatLng(-27.646620, -48.670361);

        MarkerOptions brtm = new MarkerOptions();
        br=mMap.addMarker(brtm.position(brazil).title("Marker in Brazil"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(brazil));

        final LatLng egypt = new LatLng(24.453518, 35.199905);

        MarkerOptions egyptM = new MarkerOptions();
        eg=mMap.addMarker(egyptM.position(egypt).title("Marker in Egypt"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(egypt));

        final LatLng southafrica = new LatLng(-34.414272, 19.248734);

        MarkerOptions soutM = new MarkerOptions();
        sa=mMap.addMarker(soutM.position(southafrica).title("Marker in South Africa"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(southafrica));

        final LatLng china = new LatLng(22.542883, 114.062996);

        MarkerOptions chinaM = new MarkerOptions();
        chi=mMap.addMarker(chinaM.position(china).title("Marker in China"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(china));

        final LatLng india = new LatLng( 21.7679, 78.8718);

        MarkerOptions indiaM = new MarkerOptions();
        ind=mMap.addMarker(indiaM.position(india).title("Marker in India"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(india));

        final LatLng Austrialia = new LatLng( -37.649967, 144.880600);

        MarkerOptions AusM = new MarkerOptions();
       aus=mMap.addMarker(AusM.position(Austrialia).title("Marker in Australia"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Austrialia));





        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {      //mMap is a GoogleMap object
            @Override
            public boolean onMarkerClick(Marker arg0) {
                if(arg0.equals(sydn)) {
                    Intent intent = new Intent(MapsActivity.this,visitAust.class);
                    startActivity(intent);
                    return true;
                }

                else if (arg0.equals(per)) {
                    Intent intent = new Intent(MapsActivity.this, visitperu.class);
                    startActivity(intent);
                    return true;
                }
                else if (arg0.equals(br)) {
                    Intent intent = new Intent(MapsActivity.this,visitbraz.class);
                    startActivity(intent);
                    return true;
                }
                else if (arg0.equals(eg)) {
                    Intent intent = new Intent(MapsActivity.this, visiteg.class);
                    startActivity(intent);
                    return true;
                }
                else if (arg0.equals(sa)) {
                    Intent intent = new Intent(MapsActivity.this, visitso.class);
                    startActivity(intent);
                    return true;
                }
                else if (arg0.equals(chi)) {
                    Intent intent = new Intent(MapsActivity.this, visistchi.class);
                    startActivity(intent);
                    return true;
                }
                else if (arg0.equals(ind)) {
                    Intent intent = new Intent(MapsActivity.this, visitind.class);
                    startActivity(intent);
                    return true;
                }
                else if (arg0.equals(aus)) {
                    Intent intent = new Intent(MapsActivity.this, visitAust.class);
                    startActivity(intent);
                    return true;
                }







                return false;
            }
        });
    }


}
