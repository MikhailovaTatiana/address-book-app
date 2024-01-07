document.addEventListener("DOMContentLoaded", () => {
  addressFunctions.addressesInTable();
  personFunctions.personsInTable();
});


addressFunctions = {

  addressesInTable: function () {
    fetch("http://localhost:8080/addresses", {
      headers: {
        "Access-Control-Allow-Origin": "*"
      }
    }).then(response => {
      response.json()
        .then(data => {
          console.log(data);
          if (data.length > 0) {
            var temp = "";
            data.forEach((itemData) => {
              temp += "<tr>";
              temp += "<td>" + itemData.id + "</td>";
              temp += "<td>" + itemData.streetName + "</td>";
              temp += "<td>" + itemData.streetNumber + "</td>";
              temp += "<td>" + itemData.city + "</td>";
              temp += "<td>" + itemData.state + "</td>";
              temp += "<td>" + itemData.country + "</td>";
              temp += "<td>" + itemData.zipCode + "</td>";
              temp += "<td>" + itemData.persons.length + "</td>";
            });
            document.getElementById('addresses').innerHTML = temp;
          }
        }).catch((error) => {
          console.log(error);
        })
      }
    )
  }

};


personFunctions = {

  personsInTable: function () {
    fetch("http://localhost:8080/persons", {
      headers: {
        "Access-Control-Allow-Origin": "*"
      }
    }).then(response => {
      response.json()
        .then(data => {
          console.log(data);
          if (data.length > 0) {
            var temp = "";
            data.forEach((itemData) => {
              temp += "<tr>";
              temp += "<td>" + itemData.id + "</td>";
              temp += "<td>" + itemData.firstName + "</td>";
              temp += "<td>" + itemData.lastName + "</td>";
              temp += "<td>" + itemData.phone + "</td>";
              temp += "<td>" + itemData.email + "</td>";
            });
            document.getElementById('persons').innerHTML = temp;
          }
        }).catch((error) => {
          console.log(error);
        })
      }
    )
  }

};
