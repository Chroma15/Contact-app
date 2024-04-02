import { useState } from "react";
import { useEffect } from "react";

function ListAllContacts() {

    const [allContacts, setAllContacts] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/contacts")
            .then(r => r.json())
            .then(responseData => {
                console.log(responseData);
                setAllContacts(responseData);
            })
    }, []);

    return (<>
        <h1>List all contacts</h1>

        {
        allContacts
            .map(contact => {
                return (<div className="js-contact-item" key={contact.id}>
                    {contact.id} - 
                    {contact.firstName} - 
                    {contact.lastName} - 
                    {contact.phoneNumber}
                </div>);
            })
        }
    </>);
}

export default ListAllContacts;

