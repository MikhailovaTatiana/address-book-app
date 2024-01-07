document.addEventListener("DOMContentLoaded", () => {
//  addressFunctions.getAddressesTest();
//  personFunctions.getPersonsTest();
    
  const mainElement = document.querySelector("main");
  addressFunctions.getAddresses(mainElement);
});
    
addressFunctions = {
  getAddressesTest: function () {
    fetch("http://localhost:8080/addresses", {
      headers: {
        "Access-Control-Allow-Origin": "*"
      }
    })
      .then((response) => response.json())
      .then((data) => console.log({ data }))
      .catch((error) => {
        console.log(error);
      });
  },

  getAddresses: function (element) {
    fetch("http://localhost:8080/addresses", {
      headers: {
        "Access-Control-Allow-Origin": "*"
      }
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        //        element.textContent = data.length;
        const addressList = document.createElement("div");
        for (let i = 0; i < data.length; i++) {
          const address = data[i];
          const addressHeading = document.createElement("h2");
          addressHeading.textContent = `${address.id} ${address.streetName} ${address.streetNumber}`;
          const addressDiv = document.createElement("div");
          addressDiv.appendChild(addressHeading);
          addressList.appendChild(addressDiv);
        }
        element.appendChild(addressList);
        console.log("data=", data);
      })
      .catch((error) => {
        console.log(error);
      });
  }

};

personFunctions = {
  getPersonsTest: function () {
    fetch("http://localhost:8080/persons", {
      headers: {
        "Access-Control-Allow-Origin": "*"
      }
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => console.log({ data }))
      .catch((error) => {
        console.log(error);
      });
  }

};
