<template>
    <div>
      <b-container fluid="md" class="ml-auto mt-3 pt-3 mr-auto" >
        
        <div class="FirstPage">
          <b-card>
            <h1 class="text mt-2 pt-2">
            <strong> Register Customer</strong>
            </h1>
            <p></p>


            <b-form>
              <b-row  >
                <b-col class="ml-12" cols="12" sm="6" md="5">
                   <b-form-input v-model="customer.Fname" placeholder="Frist Name"></b-form-input> 
                </b-col>
                <hr>
                
                 <b-col class="ml-10" cols="12" sm="6" md="5">
                    <b-form-input v-model="customer.Lname" placeholder="Last Name"></b-form-input>
                </b-col>
              </b-row>
              <p></p>

              <b-row>
                <b-col class="ml-12" cols="10" sm="6" md="6">
                   <b-form-input v-model="customer.Email" placeholder="Email"></b-form-input>
                </b-col>
              </b-row>
              <p></p>

                <b-row>
                <b-col class="ml-12" cols="10" sm="6" md="6">
                   <b-form-input v-model="customer.Phone" placeholder="Phone number"></b-form-input>
                </b-col>
              </b-row>

            </b-form>
          </b-card>
        </div>
        <footer>
          <b-container class="ml-auto mt-3 pt-3 mr-auto">
            <b-row align-h="center">
              
                <b-button 
                onclick="RegisterCustomer"
                variant="primary">REGISTER
                  
                </b-button>
                
           
                <b-button 
               @click="clear()"
              
                variant="primary">CLEAR</b-button>
              
                <b-button 
                @click="Back"
                variant="primary">BACK</b-button>
            
            </b-row>
            
          </b-container>
        </footer>


      </b-container>
      </div>
    
    
</template>

<script>
import http from "../http-common";
export default {
  name: "customer",
  data() {
    return {
      customer: {
        Fname:"",
        Lname:"",
        Email:"",
        Phone:"",
      },
    
    };
  },
  methods: {
    /* eslint-disable no-console */
    //ใช้ router ช่วยในการทำงาน
    // ดึงข้อมูล Title ใส่ combobox
    
    // function เมื่อกดปุ่ม Register
    RegisterCustomer() {
      http
        .post("/customer/" +
            this.customer.Fname +
            "/" +
            this.customer.Lname +
            "/" +
            this.customer.Email +
            "/" +
            this.customer.Phone
            )
        .then(response => {
          //this.types = response.data;
          console.log(response.data);
        alert("สมัครสมาชิกสำเร็จ")
        this.customer.Fname = ""
        this.customer.Lname = ""
        this.customer.Email = ""
        this.customer.Phone=""
        })
        .catch(e => {
          console.log(e); 
          this.customer.Fname = ""
          this.customer.Lname = ""
          this.customer.Email = ""
          this.customer.Phone=""
        });
       
      // alert('Register complete')
      
      
    },
    /*ปุ่มclear -- ล้างข้อมูลทั้งหมดใน Register ถ้าต้องลบทั้งหมดที่พิมพ์ไป*/

    clear() {
     // this.$refs.form.reset();
      this.customer.Fname = ""
      this.customer.Lname = ""
      this.customer.Email = ""
      this.customer.Phone=""
    
     
    },
    Back(){
      this.$router.push({name: 'Dashbord'}); 
      }
    /* eslint-enable no-console */
  },
  mounted() {

  }
};
</script>

<style scoped>
div.FirstPage {
  margin: 50px, 20px;
  padding: 20px, 50px;
}
span {
  font: 20px BankGothic Md BT, sans-serif;
  -width: 100%;
}

h1.text {
  text-align: center;
  font: 30px BankGothic Md BT, sans-serif;
  width: 100%;
}
</style>