package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val backButton = findViewById<Button>(R.id.icon_back)
        backButton.setOnClickListener {
            navigateToPage(MainActivity::class.java)
        }

        // JSON 파일 읽기
        val contactJson = assets.open("json/contact_data.json").reader().readText()

        // JSON Array 파싱
        val contactArrayJson = JSONArray(contactJson)

        val contactItemList = ArrayList<ContactItem>()

        for (index in 0 until contactArrayJson.length()) {
            val jsonObject = contactArrayJson.getJSONObject(index)

            contactItemList.add(ContactItem(jsonObject.getString("Email"), jsonObject.getString("Name"), jsonObject.getString("Organization") ,jsonObject.getString("Phone")))
        }

        val adapter = ContactListAdapter(
            contactItemList,
            LayoutInflater.from(this),
            this
        )
        findViewById<RecyclerView>(R.id.ContactList).adapter = adapter

    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}

class ContactListAdapter(
    val contactItemList: ArrayList<ContactItem>,
    val inflater: LayoutInflater,
    val activity: ContactActivity
) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactName: TextView
        val contactOrganization: TextView
        val contactPhone: TextView
        val contactEmail: TextView

        init {
            contactName = itemView.findViewById(R.id.person_name)
            contactOrganization = itemView.findViewById(R.id.person_institute)
            contactPhone = itemView.findViewById(R.id.person_phone)
            contactEmail = itemView.findViewById(R.id.person_email)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.contactName.setText(contactItemList[position].Name)
        holder.contactOrganization.setText(contactItemList[position].Organization)
        holder.contactPhone.setText(contactItemList[position].Phone)
        holder.contactEmail.setText(contactItemList[position].Email)
    }

    override fun getItemCount(): Int {
        return contactItemList.size
    }
}