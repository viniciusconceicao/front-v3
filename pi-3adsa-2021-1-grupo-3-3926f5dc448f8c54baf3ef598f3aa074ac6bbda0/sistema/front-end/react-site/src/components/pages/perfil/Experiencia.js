import React, { useEffect, useState } from "react";
import { AddCircleOutline } from "@material-ui/icons";
import { Tab } from '../../molecules/Tab';
import { BoxPerfil, TabsPattern } from './Perfil';
import { useHistory } from "react-router";
import CardExperiencia from '../../molecules/perfil/CardExperiencia'
import { Modal, Skeleton, message } from 'antd';
import EditarInfoPerfil from "../../molecules/modal/EditarInfoPerfil";
import api from '../../../services/api';
import EmptyState from "../../organisms/EmptyState";
import Success from "../../organisms/Success";

const Experiencia = () => {
  const idStorage = localStorage.getItem('idUser');
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [sucesso, setSucesso] = useState(false);
  const [listExperience, setListExperience] = useState([]);
  const [loading, setLoading] = useState(false);
  const [loadingButton, setLoadingButton] = useState(false);
  const [data, setData] = useState({
    nameCompany: "",
    position: "",
    functions: "",
    locality: "",
    descriptionExperience: "",
    startDateExperience: "",
    endDateExperience: "",
  })

  function handle(e) {
    const newData = { ...data };
    newData[e.target.id] = e.target.value;
    console.log(newData)
    setData(newData)
  }

  const postNewExperience = async (e) => {
    e.preventDefault();
    setLoadingButton(true);

    try {
      await api.post(`/api/experiences/${idStorage}`, {
        nameCompany: data.nameCompany,
        position: data.position,
        functions: data.functions,
        locality: data.locality,
        descriptionExperience: data.descriptionExperience,
        startDateExperience: data.startDateExperience,
        endDateExperience: data.endDateExperience,
      })
      setSucesso(true);

      setData({
        nameCompany: "",
        position: "",
        functions: "",
        locality: "",
        descriptionExperience: "",
        startDateExperience: "",
        endDateExperience: "",
      })
      console.log("sucesso ao add experiencia!")
    } catch (err) {
      message.error('Erro ao adicionar experi??ncia. Tente novamente!');
      console.log("erro ao add experiencia")
    }

    setLoadingButton(false);

  }

  const getExperience = async () => {

    try {
      setLoading(true);
      const response = await api.get(`/api/experiences/user/${idStorage}`);
      setListExperience(response.data)
      console.log("minhas experiencias:", response.data)
      setLoading(false);
    } catch (err) {
      console.log("n??o foi poss??vel listar as experiencias", err)
    }
  }

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  const history = useHistory();

  useEffect(() => getExperience(), [sucesso]);

  return (
    <>
      <TabsPattern>
        <Tab text="Compet??ncias"
          style={{ borderRadius: "10px 0 0 0" }}
          onClick={() => history.push('/perfil')} />
        <Tab text="Experi??ncias"
          active={true}
          onClick={() => history.push('/perfil/experiencia')} />
        <Tab text="Forma????o Acad??mica"
          onClick={() => history.push('/perfil/formacao')} />
        <Tab text="Projetos Realizados"
          style={{ borderRadius: "0 10px 0 0" }}
          onClick={() => history.push('/perfil/projetos')} />
        {/* <Tab text="Reputa????o"
          style={{ borderRadius: "0 10px 0 0" }}
          onClick={() => history.push('/perfil/reputacao')} /> */}
      </TabsPattern>

      <BoxPerfil>
        <h2><AddCircleOutline
          className="add"
          onClick={showModal} /> Experi??ncias</h2>

        {
          loading ?
            <>
              <Skeleton paragraph={{ rows: 2 }} active />
              <Skeleton paragraph={{ rows: 2 }} active />
            </>
            :
            listExperience ?

              listExperience.map((experiencia) => {
                return (
                  <CardExperiencia
                    id={experiencia.idExperience}
                    cargo={experiencia.position}
                    empresa={experiencia.nameCompany}
                    funcoes={experiencia.functions}
                    desc={experiencia.descriptionExperience}
                    local={experiencia.locality} />
                )
              })

              :
              <EmptyState type="arquivo" text="Voc?? n??o possui experi??ncias cadastradas!" />
        }

      </BoxPerfil>

      <Modal
        visible={isModalVisible}
        onOk={handleOk}
        onCancel={handleCancel}
        footer={null}>

        {
          !sucesso ?

            <EditarInfoPerfil
              loading={loadingButton}
              type="adicionar"
              name="experi??ncia profissional"
              inputOne={{
                label: "Empresa",
                value: data.nameCompany,
                id: "nameCompany",
                onchange: e => handle(e)
              }}
              inputTwo={{
                label: "Cargo",
                value: data.position,
                id: "position",
                onchange: e => handle(e)
              }}
              inputThree={{
                label: "Fun????es",
                value: data.functions,
                id: "functions",
                onchange: e => handle(e)
              }}
              inputFour={{
                label: "Localidade",
                value: data.locality,
                id: "locality",
                onchange: e => handle(e)
              }}
              inputFive={{
                label: "Descri????o",
                value: data.descriptionExperience,
                id: "descriptionExperience",
                onchange: e => handle(e)
              }}
              dataInicio={{
                value: data.startDateExperience,
                id: "startDateExperience",
                onchange: e => handle(e)
              }}
              dataFinal={{
                value: data.endDateExperience,
                id: "endDateExperience",
                onchange: e => handle(e)
              }}
              submit={(e) => postNewExperience(e)} />
            :
            <Success
              text="Experi??ncia cadastrada com sucesso!"
              textButton="Cadastrar mais experi??ncias"
              type="2"
              onclick={() => setSucesso(false)} />
        }

      </Modal>

    </>
  );
};
export default Experiencia;

