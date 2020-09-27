<template>

<div>
  <b-card 
    
    header="Add Order"
    style="max-width: 30rem;  "
    header-text-variant="white"

    header-bg-variant="primary"
   
   
  >

    <div>
    <h>รายชื่อลูกค้า</h>
     <b-form-select v-model="selected" :options="options"></b-form-select>
    </div>

    <p></p>

    <div>
    <h>ชื่อสินค้า</h>
     <b-form-select v-model="selected" :options="options"></b-form-select>
    </div>
    
    
    <p></p>

    <div>
    <h>ปลายทาง</h>
     <b-form-select v-model="selected" :options="options" ></b-form-select>
    </div>

    <p></p>
     <b-row align-h="center">
              
                <b-button 
                onclick="RegisterCustomer"
                variant="success">SAVE
                  
                </b-button>
                
           
                <b-button 
               @click="clear()"
              
                variant="danger">CLEAR</b-button>
              
                <b-button 
                @click="Back"
                variant="primary">BACK</b-button>
            
            </b-row>
            



  </b-card>
</div>
    
</template>
