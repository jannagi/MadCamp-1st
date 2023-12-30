import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.ContactActivity
import com.example.firstapp.ContactItem
import com.example.firstapp.R
import java.util.Locale

class ContactListAdapter(
    val contactItemList: ArrayList<ContactItem>,
    val inflater: LayoutInflater,
    val activity: ContactActivity
) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>(), Filterable {

    var filteredContactItemList: ArrayList<ContactItem> = contactItemList

    interface OnItemClickListener {
        fun onItemClick(contactItem: ContactItem)
    }

    var onItemClickListener: OnItemClickListener? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val contactName: TextView
        val contactOrganization: TextView
        val contactPhone: TextView
        val contactEmail: TextView

        init {
            contactName = itemView.findViewById(R.id.person_name)
            contactOrganization = itemView.findViewById(R.id.person_institute)
            contactPhone = itemView.findViewById(R.id.person_phone)
            contactEmail = itemView.findViewById(R.id.person_email)

            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            onItemClickListener?.onItemClick(contactItemList[adapterPosition])
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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                filteredContactItemList = if (charString.isEmpty()) {
                    contactItemList
                } else {
                    val filteredList = ArrayList<ContactItem>()
                    for (contactItem in contactItemList) {
                        if (contactItem.Name.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(contactItem)
                        }
                    }
                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredContactItemList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredContactItemList = results?.values as ArrayList<ContactItem>
                notifyDataSetChanged()
            }
        }
    }
}