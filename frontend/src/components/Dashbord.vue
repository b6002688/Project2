<template>
    
 <b-container fluid="md" class="ml-auto mt-3 pt-3 mr-auto" >
        
        <div>
          <b-card >
            <b-row align-h="center">
            <h3 class="text mt-2 pt-2">
            <strong> Menu </strong>
            </h3>
            </b-row>
            <p></p>
             
    
            <b-form>
               <b-row align-h="center">
                <b-button 
                @click="Register"
                onclick="RegisterCustomer"
                variant="primary">REGISTER
                  
                </b-button>
               </b-row>
              <p></p>
              <b-row align-h="center">
                <b-button 
                @click="Order"
                onclick="RegisterCustomer"
                variant="primary">ORDER
                  
                </b-button>
               </b-row>
              <p></p>
              <b-row align-h="center">
                <b-button 
                onclick="RegisterCustomer"
                variant="primary">STOCK
                  
                </b-button>
               </b-row>
              <p></p>
              <b-row align-h="center">
                <b-button 
                onclick="RegisterCustomer"
                variant="primary">QUEUE
                  
                </b-button>
               </b-row>
              <p></p>
              <b-row align-h="center">
                <b-button 
                onclick="RegisterCustomer"
                variant="primary">PACK
                  
                </b-button>
               </b-row>
              <p></p>
              <b-row align-h="center">
                <b-button 
                onclick="RegisterCustomer"
                variant="primary">HANDOVER
                  
                </b-button>
               </b-row>
              <p></p>
            </b-form>
          </b-card>
        </div>
        
              

      </b-container>
</div>
    
</template>
<script>
export default {
  
 methods: {

Register(){
     this.$router.push({name: 'Register'});
 },
 Order(){
     this.$router.push({name: 'Order'});
 },
Stock(){
     this.$router.push({name: 'Stock'});
 },
Queue(){
     this.$router.push({name: 'Queue'});
 },
Pack(){
     this.$router.push({name: 'Pack'});
 },
 Handover(){
     this.$router.push({name: 'Handover'});
 }
},
mounted(){
  
}
}
</script>
