package ec.edu.uce.dispmoviles.trabajo1hemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Desplegado",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Colapsado",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String ejer = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(
                        getApplicationContext(), listDataHeader.get(groupPosition) + " : " + ejer, Toast.LENGTH_SHORT)
                        .show();
                Intent intento = new Intent();
                switch (ejer) {
                    case "1. Registro de Cédula":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.registrocedula.MainActivity.class);
                        break;
                    case "1. Styles":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer1.StylesActivity.class);
                        break;
                    case "1. Themed":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer1.ThemedActivity.class);
                        break;
                    case "2. System Ui":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer2.MainActivity.class);
                        break;
                    case "3. Custom Widgets":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer3.MyActivity.class);
                        break;
                    case "4. Animate Property - Flipper":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer4_1.FlipperActivity.class);
                        break;
                    case "4. Animate Property - Flipper Pause":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer4_1.FlipperPauseActivity.class);
                        break;
                    case "4. Animate View Property":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer4_2.AnimateActivity.class);
                        break;
                    case "4. Animation XML":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer4_3.FlipperActivity.class);
                        break;
                    case "5. Animate Layout":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer5.MainActivity.class);
                        break;
                    case "6. Universal App":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer6.UniversalActivity.class);
                        break;
                    case "7. Adapter View Empty":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer7.EmptyActivity.class);
                        break;
                    case "8. Custom List":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer8.MyActivity.class);
                        break;
                    case "9. Section Headers":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer9.SectionsActivity.class);
                        break;
                    case "10. Compound Controls":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer10.MyActivity.class);
                        break;
                    case "11. Transition Animations":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer11.MainActivity.class);
                        break;
                    case "11. Transition Animations - Support":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer11.SupportActivity.class);
                        break;
                    case "11. Transition Animations - Native":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer11.NativeActivity.class);
                        break;
                    case "12. Static Transforms":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer12.MainActivity.class);
                        break;
                    case "12. Static Transforms - Scroll":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer12.ScrollActivity.class);
                        break;
                    case "13. Recycler View":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap1.ejer13.SimpleRecyclerActivity.class);
                        break;
                    case "1. Action Bar - SupportAction":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer1.SupportActionActivity.class);
                        break;
                    case "1. Action Bar - SupportToolbar":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer1.SupportToolbarActivity.class);
                        break;
                    case "3. - 4. Rotation - Lock":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer3_4.LockActivity.class);
                        break;
                    case "3. - 4. Rotation - Manual":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer3_4.ManualRotationActivity.class);
                        break;
                    case "5. Pop Up Menus":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer5.ActionActivity.class);
                        break;
                    case "6. Alert Dialog - 1":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer6.CustomItemActivity.class);
                        break;
                    case "6. Alert Dialog - 2":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer6.DialogActivity.class);
                        break;
                    case "7. Options Menu":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer7.OptionsActivity.class);
                        break;
                    case "8. Custom Back":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer8.MyActivity.class);
                        break;
                    case "10. Text Watchers":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer10.MyActivity.class);
                        break;
                    case "11. Custom IME":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer11.MainActivity.class);
                        break;
                    case "13. - 14. Custom Touch - RemoteScroll":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer13_14.RemoteScrollActivity.class);
                        break;
                    case "13. - 14. Custom Touch - Delegate":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer13_14.DelegateActivity.class);
                        break;
                    case "13. - 14. Custom Touch - Image":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer13_14.ImageActivity.class);
                        break;
                    case "13. - 14. Custom Touch - PanScroll":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer13_14.PanScrollActivity.class);
                        break;
                    case "15. Touch Intercept":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer15.DisallowActivity.class);
                        break;
                    case "16. Drag Touch":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer16.DragTouchActivity.class);
                        break;
                    case "17. Drawer Layout - Support":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer17.SupportActivity.class);
                        break;
                    case "17. Drawer Layout - Toolbar":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer17.ToolbarActivity.class);
                        break;
                    case "18. View Pager":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer18.PagerActivity.class);
                        break;
                    case "18. View Pager - Fragment":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer18.FragmentPagerActivity.class);
                        break;
                    case "19. Tabs":
                        intento.setClass(MainActivity.this, ec.edu.uce.dispmoviles.cap2.ejer19.ActionTabsActivity.class);
                        break;
                }
                startActivityForResult(intento, 1);
                return false;
            }
        });

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Deberes");
        listDataHeader.add("Capítulo 1");
        listDataHeader.add("Capítulo 2");

        // Adding child data
        List<String> deberes = new ArrayList<String>();
        deberes.add("1. Registro de Cédula");

        List<String> cap1 = new ArrayList<String>();
        cap1.add("1. Styles");
        cap1.add("1. Themed");
        cap1.add("2. System Ui");
        cap1.add("3. Custom Widgets");
        cap1.add("4. Animate Property - Flipper");
        cap1.add("4. Animate Property - Flipper Pause");
        cap1.add("4. Animate View Property");
        cap1.add("4. Animation XML");
        cap1.add("5. Animate Layout");
        cap1.add("6. Universal App");
        cap1.add("7. Adapter View Empty");
        cap1.add("8. Custom List");
        cap1.add("9. Section Headers");
        cap1.add("10. Compound Controls");
        cap1.add("11. Transition Animations");
        cap1.add("11. Transition Animations - Support");
        cap1.add("11. Transition Animations - Native");
        cap1.add("12. Static Transforms");
        cap1.add("12. Static Transforms - Scroll");
        cap1.add("13. Recycler View");

        List<String> cap2 = new ArrayList<String>();
        cap2.add("1. Action Bar - SupportAction");
        cap2.add("1. Action Bar - SupportToolbar");
        cap2.add("3. - 4. Rotation - Lock");
        cap2.add("3. - 4. Rotation - Manual");
        cap2.add("5. Pop Up Menus");
        cap2.add("6. Alert Dialog - 1");
        cap2.add("6. Alert Dialog - 2");
        cap2.add("7. Options Menu");
        cap2.add("8. Custom Back");
        cap2.add("10. Text Watchers");
        cap2.add("11. Custom IME");
        cap2.add("13. - 14. Custom Touch - RemoteScroll");
        cap2.add("13. - 14. Custom Touch - Delegate");
        cap2.add("13. - 14. Custom Touch - Image");
        cap2.add("13. - 14. Custom Touch - PanScroll");
        cap2.add("15. Touch Intercept");
        cap2.add("16. Drag Touch");
        cap2.add("17. Drawer Layout - Support");
        cap2.add("17. Drawer Layout - Toolbar");
        cap2.add("18. View Pager");
        cap2.add("18. View Pager - Fragment");
        cap2.add("19. Tabs");

        listDataChild.put(listDataHeader.get(0), deberes);
        listDataChild.put(listDataHeader.get(1), cap1);
        listDataChild.put(listDataHeader.get(2), cap2);

    }

}
