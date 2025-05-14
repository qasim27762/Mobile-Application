package com.example.firebase2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etId;
    Button btnAdd, btnRead, btnUpdate, btnDelete;
    TextView tvResult;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etId = findViewById(R.id.etId);
        btnAdd = findViewById(R.id.btnAdd);
        btnRead = findViewById(R.id.btnRead);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        tvResult = findViewById(R.id.tvResult);

        dbRef = FirebaseDatabase.getInstance().getReference("Users");

        //val database = Firebase.database;
        //val myRef = database.getReference("message");
        //myRef.setValue("Hello, World!");


        // CREATE
        btnAdd.setOnClickListener(v -> {
            String id = dbRef.push().getKey();
            String name = etName.getText().toString();
            String age = etAge.getText().toString();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)) {
                Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            User user = new User(name, age);
            dbRef.child(id).setValue(user);
            Toast.makeText(MainActivity.this, "User added", Toast.LENGTH_SHORT).show();
        });

        // READ
        btnRead.setOnClickListener(v -> {
            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    StringBuilder builder = new StringBuilder();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        User user = ds.getValue(User.class);
                        builder.append("ID: ").append(ds.getKey())
                                .append("\nName: ").append(user.name)
                                .append("\nAge: ").append(user.age)
                                .append("\n\n");
                    }
                    tvResult.setText(builder.toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(MainActivity.this, "Failed to read", Toast.LENGTH_SHORT).show();
                }
            });
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            String id = etId.getText().toString();
            String name = etName.getText().toString();
            String age = etAge.getText().toString();

            if (TextUtils.isEmpty(id)) {
                Toast.makeText(MainActivity.this, "Enter ID to update", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = new User(name, age);
            dbRef.child(id).setValue(user);
            Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_SHORT).show();
        });
        // DELETE
        btnDelete.setOnClickListener(v -> {
            String id = etId.getText().toString();
            if (TextUtils.isEmpty(id)) {
                Toast.makeText(MainActivity.this, "Enter ID to delete", Toast.LENGTH_SHORT).show();
                return;
            }
            dbRef.child(id).removeValue();
            Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
        });
    }

    public static class User {
        public String name;
        public String age;

        public User() {
        }  // Needed for Firebase

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}





