package caidat.dmt.contenprovider_listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {
    private static final int contact_code=1001;
    ListView listView;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        addControl();
        showallcontact();
    }

    private void showallcontact() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
            String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vitriCotName = cursor.getColumnIndex(tenCotName);
            int vitriCotPhone = cursor.getColumnIndex(tenCotPhone);
            String name = cursor.getString(vitriCotName);
            String phone = cursor.getString(vitriCotPhone);
            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            arrayAdapter.notifyDataSetChanged();
        }
    }

    private void addControl() {
        listView = findViewById(R.id.lv_DanhBa);
        dsDanhBa = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa);
        listView.setAdapter(arrayAdapter);
    }
}