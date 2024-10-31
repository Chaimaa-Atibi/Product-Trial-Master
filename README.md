# Data-Lake-ML-DEMO

To illustrate the benefits of data lakes for data science projects, we’ll do a simple demo of ML cash-flow forecasting service tested on different business cases with FBTI and Loan IQ activities of a given customer. 

The chosen business cases of our solution are as follows: 

- Negative flows of Trade activity for purchases of goods (data related to the Import letters of credit), and positive on the Lending side for the release of initial funds (amount credited to the borrower). 

- Positive flows of Trade activity for sales of goods (data related to the Export letters of credit), and negative flows on the Lending side for the repayment of capital (debit from borrower account). 

- Flow of charges and interest on the Trade side (Import) and capital repayment on the Lending side. 

- Income flows on the Trade side (Export) and initial release of funds on the Lending side. 

- All flows of both activities, except financial charges. 

And here is an Example of adaptation with Power BI: Business Case N° 2 

- First Page : Outliers’ detection in Net Amount data using the unsupervised machine learning algorithm One-Class Support Vector Machine (SVM) 
- Second Page : Net Amount forecasting using Exponential smoothing model with Python and Power BI 
